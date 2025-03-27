package com.opentext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StockController {

	private Stock stock1 = new Stock(1, "Google");
	private Stock stock2 = new Stock(2, "Microsoft");
	private List<Stock> stocks = Arrays.asList(stock1, stock2);
	private ArrayList<Stock> allStocks = new ArrayList<Stock>(stocks);

	public StockController() {
		super();
		System.out.println("StockController constructor called");
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
			res.sendRedirect("login");
		}
		return null;
	}

	@GetMapping("/success")
	public String successLogin() {
		return "success";
	}

	@PostMapping("/performLogin")
	public String performLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("performLogin");
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		HttpSession session;
		if (username.equals(password)) {
			session = req.getSession(true);
			session.setAttribute("username", username);
			System.out.println("returning success");
			res.sendRedirect("success");
		} else {
			System.out.println("returning failure");
			res.sendRedirect("failure");
		}
		return null;
	}

	@GetMapping("/stock/{id}")
	public String getStockDetails(@PathVariable("id") String stockId, Model model) {
		Stock st;
		for (Stock s : allStocks) {
			if (s.getId() == Integer.parseInt(stockId)) {
				st = s;
				model.addAttribute("stock", st); // Add the stock object to the model
				return "stockDetails"; // Return the JSP view name
			}
		}
		model.addAttribute("stock", null); // Add the stock object to the model
		return "stockDetails"; // Return the JSP view name
	}
}
