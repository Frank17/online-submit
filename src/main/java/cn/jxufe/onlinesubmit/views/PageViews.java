package cn.jxufe.onlinesubmit.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面视图管理类
 * 
 * @author Frank
 *
 */
@Controller
public class PageViews {

	private static final String PROJECT_TITLE = "在线测试提交系统";

	@Value("${spring.views.index}")
	private String indexPage;

	@Value("${spring.views.login}")
	private String loginPage;

	@Value("${spring.views.submit}")
	private String submitPage;
	
	@Value("${spring.project.version}")
	private float version;

	/**
	 * 首页渲染前进行的操作
	 * @param model 模型，使用模型进行属性设置，并渲染到页面
	 * @param session 当前服务请求的session
	 * @return 首页文件名
	 */
	@RequestMapping("/")
	public String indexPage(Model model, HttpSession session) {

		// 添加标题
		model.addAttribute("title", PROJECT_TITLE);

		session.setAttribute("version", version);
		
		return indexPage;
	}

	/**
	 * 登录页面
	 * @return 登录页面模板名
	 */
	@RequestMapping("/page/login")
	public String loginPage() {
		return loginPage;
	}
	
	@RequestMapping("/page/about")
	public String aboutPage() {
		return "about";
	}

	/**
	 * 文件提交页面路由
	 * @param request 请求实例，用于获取请求IP地址
	 * @param model 模型，通过设置属性并渲染到模板
	 * @return 提交页面模板名
	 */
	@RequestMapping("/submit")
	public String submitPage(HttpServletRequest request, Model model) {

		String ipAddr = null;

		String[] PROXY_REMOTE_IP_ADDRESS = { "X-Forwarded-For", "X-Real-IP" };

		for (int i = 0; i < PROXY_REMOTE_IP_ADDRESS.length; i++) {
			String ip = request.getHeader(PROXY_REMOTE_IP_ADDRESS[i]);
			if (null != ip && ip.trim().length() > 0) { // 代理服务器
				int offset = ip.trim().charAt(',');
				if (offset < 0) {
					ipAddr = null;
				} else {
					ipAddr = ip.trim().substring(0, offset);
				}
			} else {
				ipAddr = request.getRemoteAddr();
			}
		}

		model.addAttribute("ipaddr", ipAddr);

		return submitPage;
	}
}
