package cn.edu.bm.utils;


import cn.edu.bm.model.Ticket;
import org.joda.time.DateTime;

/**
 * Created by nowcoder on 2018/08/07 下午3:31
 */
public class TicketUtils {

  public static Ticket next(int uid){

    Ticket ticket = new Ticket();//new
    ticket.setTicket(UuidUtils.next());
    ticket.setUserId(uid);
    //设置t票过期时间
    DateTime expiredTime = new DateTime();
    expiredTime = expiredTime.plusMonths(3);
    ticket.setExpiredAt(expiredTime.toDate());

    return ticket;
  }

}
