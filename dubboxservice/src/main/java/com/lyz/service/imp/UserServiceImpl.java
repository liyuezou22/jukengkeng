package com.lyz.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyz.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "海阔凭鱼跃，天高任鸟飞！";
    }
}
