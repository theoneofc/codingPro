package cn.edu.bm.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nowcoder on 2018/08/07 下午2:56
 */
public class CookieUtils {

  private static int COOKIE_AGE = 60 * 60 * 24 * 7;//七天

  public static void writeCookie(String key, String value, HttpServletResponse response) {
    Cookie cookie = new Cookie(key, value);//new
    cookie.setPath("/");
    cookie.setMaxAge(COOKIE_AGE);
    response.addCookie(cookie);//其实这里是一个知识点，也就是Spring Boot中对cookie的处理，生成啊、获取啊
  }

  public static String getCookie(String key, HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();//所以get到的cookie是有可能多个的吗，这里是数组的数据结构
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(key)) {
          return cookie.getValue();
        }
      }
    }
    return null;
  }

  public static void removeCookie(String key, HttpServletRequest request, //没有地方用了这个函数啊，所以也是未实现的功能？
                                  HttpServletResponse response) {

    Cookie[] cookies = request.getCookies();

    for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
      if ((key).equalsIgnoreCase(cookies[i].getName())) {

        Cookie cookie = new Cookie(key, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);// 设置保存cookie最大时长为0，即使其失效
        response.addCookie(cookie);
      }
    }
  }

}
