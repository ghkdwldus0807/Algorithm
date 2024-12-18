class Solution {
    
    //id 일치하는지 확인 
    
    public boolean idMatch(String id, String idDb){
        if(id.equals(idDb))
            return true;
        else
            return false;
    } 
    
    public boolean pwMatch(String pw, String pwDb){
        if(pw.equals(pwDb))
            return true;
        else
            return false;
    } 
    
    //결과 
    
    public String resultMatch(boolean id, boolean pw){
        if(id==false)
            return "fail";
        else if(id==true && pw==false)
            return "wrong pw";
        else 
            return "login";
    }
    
    //정답 우선순위 
    
    public String answerMatch(String answer, String result){
        if (answer.length()==0){
            return result;
        }else if(answer.equals("wrong pw") && result.equals("fail"))
            return answer;
        else if(answer.equals("login") && result.equals("fail"))
            return answer;
        else if(answer.equals("login") && result.equals("wrong pw"))
            return answer;
        else 
            return result;
    }
    
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        String result ="";
        for (int i = 0 ; i<db.length; i++){
            boolean id = idMatch(id_pw[0],db[i][0]);
            boolean pw = pwMatch(id_pw[1],db[i][1]);
            result = resultMatch(id,pw);
            answer = answerMatch(answer,result);
        }
        return answer;
    }
}