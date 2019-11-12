package com.zhku.mh.entities.DTO;

import com.zhku.mh.entities.MsgContent;
import com.zhku.mh.entities.Sysmsg;

/**
 * ClassName：
 * Time：2019/11/11 9:42
 * Description：
 * Author： mh
 */
public class SysmsgDTO extends Sysmsg {
    private MsgContent msgContent;

    public MsgContent getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(MsgContent msgContent) {
        this.msgContent = msgContent;
    }
}
