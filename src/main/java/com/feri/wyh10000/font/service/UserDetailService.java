package com.feri.wyh10000.font.service;

import com.feri.wyh10000.admin.vo.PageVo;
import com.feri.wyh10000.admin.vo.R;
import com.wyh10000.domain.Rank;
import com.wyh10000.domain.UserDetail;

/**
 *@Author feri
 *@Date Created in 2018/9/14 17:03
 */
public interface UserDetailService {
   PageVo<UserDetail> queryPage(int page,int limit);
   R updateFlag(int id,int flag);


}
