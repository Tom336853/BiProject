package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AiManger {
    @Resource
    private  YuCongMingClient yuCongMingClient;

    /**
     * AI对话
     * @return
     */
    public String dochat(Long modelId,String message){
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
        System.out.println(response.getData());
        if(response == null){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"Al响应错误");
        }
        return response.getData().getContent();
    }
}
