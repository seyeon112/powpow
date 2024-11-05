package com.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.dao.AdminDAO;
import com.app.dao.CartDAO;
import com.app.dao.ProductDAO;
import com.app.dto.AdminBannerDTO;
import com.app.dto.CartDTO;
import com.app.vo.ProductVO;

public class ProductHealthController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		CartDAO cartDAO = new CartDAO();
		AdminDAO adminDAO = new AdminDAO();
		
		List<CartDTO> cartItems = cartDAO.selectAll();
		
		List<ProductVO> products = productDAO.selectAll();
		List<AdminBannerDTO> banners = adminDAO.selectAllBanners();

		req.setAttribute("products", products);
		req.setAttribute("banners", banners);
		req.setAttribute("cartSize", cartItems.size());

		result.setPath("../product/product-health-main.jsp");
		
		return result;
	}

}
