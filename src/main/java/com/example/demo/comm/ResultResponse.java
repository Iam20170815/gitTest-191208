package com.example.demo.comm;

import lombok.Getter;
import lombok.Setter;

/**
 * SDK调用统一结果应答标准
 *
 * @Author ho274688
 * @Date 2019/12/21 5:42
 */
@Getter
@Setter
public class ResultResponse {

    private static final String PI_FLAG = "PI";
    private static final String PO_FLAG = "PO";
    private static final String INTER_ERR = "ER";
    private static final String SUCCESS_FLG = "SUCC";
    private static final String SUCCESS_CODE = "00000000";

    private String respCode;
    private String respDesc;

    /**
     * 统一结果——应答码
     * 应答码规则
     * 成功：SUCC00000000
     * 失败: 2位标识+2位通道+8位错误码（不足左补0）
     *
     * @param channel 通道标识
     * @param respCd  原始应答码
     * @return ResultResponse
     */
    public static ResultResponse mappingRspCd(String channel, String respCd) {

        if (!checkInparm(channel, respCd)) {
            return null;
        }

        ResultResponse resultRsp;

        if (SUCCESS_FLG.equals(channel)) {
            resultRsp = successRspCd();
        } else {
            resultRsp = failRspCd(channel, respCd);
        }

        return resultRsp;
    }

    /**
     * 参数检查
     * 检查通过，返回true;检查不通过，返回false
     *
     * @param channel 通道标识
     * @param respCd  原始应答码
     * @return boolean
     */
    private static boolean checkInparm(String channel, String respCd) {

        if (channel.isEmpty()) {
            return channel.isEmpty();  //通道标识为空
        }

        if (respCd.length() > 8) {
            return false;  //原始应答码超长
        }

        return true;
    }

    private static ResultResponse successRspCd() {
        ResultResponse resultRsp = new ResultResponse();
        resultRsp.setRespCode(SUCCESS_FLG + SUCCESS_CODE);
        return resultRsp;
    }

    private static ResultResponse failRspCd(String channel, String respCd) {

        ResultResponse resultRsp = new ResultResponse();
        StringBuilder strBuilder = new StringBuilder();

        // 格式化8位应答码
        String respCdFormat = respCd;
        if (respCd.length() < 8) {
            respCdFormat = String.format("%0" + (8 - respCd.length()) + "d", 0) + respCd;
        }

        // 组装应答码
        // 如果某通道应答码有个性化需求，利用2位标识扩展
        switch (channel) {
            case INTER_ERR:
                strBuilder.append(PI_FLAG).append(channel).append(respCdFormat);
                break;
            default:
                strBuilder.append(PO_FLAG).append(channel).append(respCdFormat);
                break;
        }

        resultRsp.setRespCode(strBuilder.toString());
        return resultRsp;
    }
}
