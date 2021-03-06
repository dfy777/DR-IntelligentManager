package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DeviceMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.myexcept.MyExceptionHandler;
import com.example.demo.pojo.DValueEnum;
import com.example.demo.pojo.Device;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.PageUtil;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	DeviceMapper deviceMapper;
	
	/**
	 * 添加订单
	 */
	@Override
	public Result<String> addOrder(Order order, HttpServletRequest request) {
		int cid = Integer.parseInt(request.getSession().
				getAttribute(DValueEnum.LOGIN_USER_ID.getValue()).toString());
		int fid = Integer.parseInt(request.getSession().
				getAttribute(DValueEnum.CHECKED_FACTORY_ID.getValue()).toString());
		
		order.setClient_id(cid);
		order.setFac_id(fid);
		order.generateOrd_name();
		order.setPay_status("未支付");
		order.setStatus("未进行");
		order.setProgress(0);
		
		orderMapper.insertOrder(order);
		return ResultUtil.successRes();
	}
	
	
	
	@Override
	public PageResult getOrdersOnPageByFacId(PageRequest pageRequest, HttpServletRequest request) {
		return PageUtil.getPageResult(pageRequest, getOrdersInfoByFacId(pageRequest, request));
	}
	
	
	/**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
	private PageInfo<Order> getOrdersInfoByFacId(PageRequest pageRequest, HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			int pageNum = pageRequest.getPageNum();
			int pageSize = pageRequest.getPageSize();
			int fac_id = Integer.parseInt(session.getAttribute(DValueEnum.CHECKED_FACTORY_ID.getValue()).toString());
			
			
			if (pageNum <= 0 || pageSize <= 0) {
				throw new IllegalArgumentException("非法分页数据");
			}
			
			PageHelper.startPage(pageNum, pageSize);
			
			List<Order> ordersList = orderMapper.getOrderByFacIdOnPage(fac_id);
			
			//for (Order item : ordersList) {
			//	System.out.println(item.toString());
			//}
			
			return new PageInfo<Order>(ordersList);
		} catch (IllegalArgumentException e1) {
			MyExceptionHandler.takeLog(e1);
			return null;
		}
	}
	
	
	@Override
	public PageResult getAllOrdersOnPage(PageRequest pageRequest, HttpServletRequest request) {
		return PageUtil.getPageResult(pageRequest, getAllOrdersInfo(pageRequest, request));
	}
	
	
	private PageInfo<Order> getAllOrdersInfo(PageRequest pageRequest, HttpServletRequest request) {
		try {
			int pageNum = pageRequest.getPageNum();
			int pageSize = pageRequest.getPageSize();
			Integer cid = Integer.parseInt(request.getSession().
					getAttribute(DValueEnum.LOGIN_USER_ID.getValue()).toString());
			
			if (pageNum <= 0 || pageSize <= 0) {
				throw new IllegalArgumentException("非法分页数据");
			}
			
			PageHelper.startPage(pageNum, pageSize);		
			List<Order> ordersList = orderMapper.getAllOrders(cid);
			
			return new PageInfo<Order>(ordersList);
		} catch (IllegalArgumentException e1) {
			MyExceptionHandler.takeLog(e1);
			return null;
		}
	}
	
	
	/**
	 * 增加订单
	 * code:20000 创建成功
	 * code:30006 订单重复
	 * code:10000 未知错误
	 */
	@Override
	public Result<String> addOrderToFactory(Order order, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Integer fid = Integer.parseInt(session.
					getAttribute(DValueEnum.CHECKED_FACTORY_ID.getValue()).toString());
			Integer cid = Integer.parseInt(request.getSession().
					getAttribute(DValueEnum.LOGIN_USER_ID.getValue()).toString());
			
			String prodName = order.getOrd_name();
			order.setOrd_name(null);
			Product product = orderMapper.getProductByPordName(prodName);
			Device device = deviceMapper.findDeviceByFacAndDevId(fid, order.getDev_id());
			
			if (device.getOrd_id() != null) {
				return ResultUtil.data_not_allowedRes("设备正在使用");
			}
			
			//处理订单
			order.setFac_id(fid);
			order.setClient_id(cid);
			order.setOrder_id(device.getCid());
			order.setProd_id(product.getProduct_id());
			order.setProd_name(prodName);
			order.generateOrd_name();
			order.setPay_status("未支付");
			order.setStatus("未进行");
			order.setPrice(product.getPrice() * order.getProd_num());
			order.setProgress(0);
			//System.out.println(order.toString());
			orderMapper.insertOrder(order);
			
			//处理设备
			device.setOrd_id(order.getOrder_id());
			device.setProd_id(product.getProduct_id());
			device.setProd_num(order.getProd_num());
			device.setProdname(order.getProd_name());
			device.setOrdname(order.getOrd_name());
			device.setStatus("未运行");
			device.setProgress(0);
			deviceMapper.updateDevice(device);
			
			return ResultUtil.successRes();
		} catch (Exception e) {
			MyExceptionHandler.takeLog(e);
			return ResultUtil.unknown_errorReult("错误");
		}
	}
	
	
	/**
	 * code:30005:没找到订单
	 */
	@Override
	public Result<String> changeOrder(HttpServletRequest request) {
		String ord_name = request.getParameter("ord_name");
		String description = request.getParameter("description");
		String receiver = request.getParameter("receiver");
		String phone = request.getParameter("phone");
		
		Order order = orderMapper.getOrderByOrdName(ord_name);
		
		//System.out.println(description);
		//System.out.println(receiver);
		//System.out.println(phone);
 		
		if (order == null) {
			return ResultUtil.data_not_foundRes("未找到订单");
		}
		
		if (description.length() > 0) {
			order.setDescription(description);
		} else if (receiver.length() > 0) {
			order.setReceiver(receiver);
		} else if (phone.length() > 0) {
			order.setPhone(phone);
		}
		
		orderMapper.updateOrder(order);
		return ResultUtil.successRes();
	}
	
}
