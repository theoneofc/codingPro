package cn.edu.bm.service;


import cn.edu.bm.model.User;
import cn.edu.bm.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

/**
 * Created by nowcoder on 2018/08/07 下午4:03
 */
@Service
public class HostHolder {

  public User getUser() { //底层不过就是对ThreadLocal的简单set、get操作
    return ConcurrentUtils.getHost();
  }

  public void setUser(User user) { //底层不过就是对ThreadLocal的简单set、get操作
    ConcurrentUtils.setHost(user);
  }
}
