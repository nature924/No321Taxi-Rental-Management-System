package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Cars;
import com.entity.Cate;
import com.entity.Complains;
import com.entity.Orders;
import com.entity.Topic;
import com.entity.Users;
import com.service.ArticleService;
import com.service.CarsService;
import com.service.CateService;
import com.service.ComplainsService;
import com.service.OrdersService;
import com.service.TopicService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CateService cateService;
	@Autowired
	private CarsService carsService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ComplainsService complainsService;

	// TODO Auto-generated method stub
	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "出租车租赁管理系统");
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Cars> hotList = this.carsService.getCarsByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateService.getCateFront();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Cars> carsList = this.carsService.getCarsByCate(cate.getCateid());
			cate.setCarsList(carsList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		return "users/index";
	}

	// 公告
	@RequestMapping("article.action")
	public String article(String number) {
		this.front();
		List<Article> tempList = this.articleService.getAllArticle();
		PageHelper.getIndexPage(tempList, "article", "article", null, 10, number, this.getRequest());
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if ("锁定".equals(users.getStatus())) {
				this.getSession().setAttribute("message", "账户被锁定");
				return "redirect:/index/preLogin.action";
			}
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setStatus("解锁");
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/userinfo.action";
	}

	@RequestMapping("all.action")
	public String all(String number) {
		this.front();
		Cars cars = new Cars();
		cars.setStatus("待租");
		List<Cars> carsList = this.carsService.getCarsByCond(cars);
		PageHelper.getIndexPage(carsList, "cars", "all", null, 10, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("cate.action")
	public String cate(String number) {
		this.front();
		String cateid = this.getRequest().getParameter("id");
		Cars cars = new Cars();
		cars.setStatus("待租");
		cars.setCateid(cateid);
		List<Cars> carsList = this.carsService.getCarsByCond(cars);
		PageHelper.getIndexPage(carsList, "cars", "cate", cateid, 10, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("areax.action")
	public String areax(String number) {
		this.front();
		String cateid = this.getRequest().getParameter("id");
		Cars cars = new Cars();
		cars.setStatus("待租");
		cars.setAreaxid(cateid);
		List<Cars> carsList = this.carsService.getCarsByCond(cars);
		PageHelper.getIndexPage(carsList, "cars", "areax", cateid, 10, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("shops.action")
	public String shops(String number) {
		this.front();
		String cateid = this.getRequest().getParameter("id");
		Cars cars = new Cars();
		cars.setStatus("待租");
		cars.setShopsid(cateid);
		List<Cars> carsList = this.carsService.getCarsByCond(cars);
		PageHelper.getIndexPage(carsList, "cars", "shops", cateid, 10, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("recommend.action")
	public String recommend(String number) {
		this.front();
		Cars cars = new Cars();
		cars.setStatus("待租");
		cars.setRecommend("是");
		List<Cars> carsList = this.carsService.getCarsByCond(cars);
		PageHelper.getIndexPage(carsList, "cars", "recommend", null, 10, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("special.action")
	public String special(String number) {
		this.front();
		Cars cars = new Cars();
		cars.setStatus("待租");
		cars.setSpecial("是");
		List<Cars> carsList = this.carsService.getCarsByCond(cars);
		PageHelper.getIndexPage(carsList, "cars", "recommend", null, 10, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("detail.action")
	public String detail(String id) {
		this.front();
		Cars cars = this.carsService.getCarsById(id);
		cars.setHits("" + (Integer.parseInt(cars.getHits()) + 1));
		this.carsService.updateCars(cars);
		this.getRequest().setAttribute("cars", cars);
		Topic topic = new Topic();
		topic.setCarsid(id);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		return "users/detail";
	}

	// 准备结算
	@RequestMapping("preCheckout.action")
	public String preCheckout(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Cars cars = this.carsService.getCarsById(id);
		this.getRequest().setAttribute("cars", cars);
		this.getRequest().setAttribute("ordercode", "OD" + VeDate.getStringDatex());
		return "users/checkout";
	}

	// 结算
	@RequestMapping("checkout.action")
	public String checkout(Orders orders) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String id = this.getRequest().getParameter("id");
		Cars cars = this.carsService.getCarsById(id);
		String userid = (String) this.getSession().getAttribute("userid");
		long days = Math.abs(VeDate.getDays(orders.getTheend(), orders.getThestart())) + 1;
		double total = VeDate.getDouble(days * Double.parseDouble(cars.getPrice()));
		orders.setCarsid(id);
		orders.setTotal("" + total);
		orders.setStatus("待审核");
		orders.setUsersid(userid);
		orders.setAddtime(VeDate.getStringDateShort());
		this.ordersService.insertOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	@RequestMapping("showOrders.action")
	public String showOrders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(tempList, "orders", "showOrders", null, 10, number, this.getRequest());
		return "users/orderlist";
	}

	// 准备付款
	@RequestMapping("prePay.action")
	public String prePay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay";
	}

	// 付款
	@RequestMapping("pay.action")
	public String pay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("确认提车");
		this.ordersService.updateOrders(orders);
		Cars cars = this.carsService.getCarsById(orders.getCarsid());
		cars.setStatus("出租");
		this.carsService.updateCars(cars);
		return "redirect:/index/showOrders.action";
	}

	@RequestMapping("over.action")
	public String over(String id) {
		String status = "确认归还";
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus(status);
		this.ordersService.updateOrders(orders);
		Cars cars = this.carsService.getCarsById(orders.getCarsid());
		cars.setStatus("待租");
		this.carsService.updateCars(cars);
		return "redirect:/index/showOrders.action";
	}

	@RequestMapping("preTopic.action")
	public String preTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("orders", orders);
		return "users/addTopic";
	}

	@RequestMapping("addTopic.action")
	public String addTopic(Topic topic) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String id = this.getRequest().getParameter("id");
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus("已评价");
		this.ordersService.updateOrders(orders);
		String userid = (String) this.getSession().getAttribute("userid");
		topic.setUsersid(userid);
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setOrdersid(id);
		topic.setCarsid(orders.getCarsid());
		this.topicService.insertTopic(topic);

		return "redirect:/index/showOrders.action";
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	// TODO Auto-generated method stub
}
