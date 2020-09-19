package source.control;

import java.util.*;


public class GetCases {


    public static void main(String[] args) {
        String tableName = "logincases";
        GetCases.getTestCases(tableName);
    }

    //拆分用例表中的数据为 请求参数Map 和 用例信息Map
    public static List<Map<String, Map<String, Object>>> getTestCases(String tableName) {
        String sql = "select * from " + tableName;
        List<Map<String, Map<String, Object>>> resultMapList = new ArrayList<Map<String, Map<String, Object>>>();
        List<Map<String, Object>> requestMapList = ConnectMySql.getCases(sql);
        int caseNum = requestMapList.size();
        for (int i = 0; i < caseNum; i++) {
            Map<String, Object> requestParamMap = new HashMap<String, Object>();
            Map<String, Object> caseMsgMap = new HashMap<String, Object>();
            Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
            Set<String> nameSet = requestMapList.get(i).keySet();
            Map<String, Object> everyCaseMap = requestMapList.get(i);
            for (String requestName : nameSet) {
                if ("casesId,description,verifytype,expect,isrun".contains(requestName)) {
                    caseMsgMap.put(requestName, everyCaseMap.get(requestName));
                } else {
                    requestParamMap.put(requestName, everyCaseMap.get(requestName));
                }
            }
            resultMap.put("caseMsgMap", caseMsgMap);
            resultMap.put("requestParamMap", requestParamMap);
            resultMapList.add(resultMap);
        }
        return resultMapList;
    }
}
