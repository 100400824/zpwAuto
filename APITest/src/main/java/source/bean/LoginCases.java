package source.bean;

import lombok.Data;

@Data
public class LoginCases {
    private String id;
    private String description;
    private String username;
    private String password;
    private String expect;
    private String isrun;
}
