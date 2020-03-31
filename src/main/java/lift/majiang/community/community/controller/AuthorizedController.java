package lift.majiang.community.community.controller;

import lift.majiang.community.community.dto.AccesstokenDTO;
import lift.majiang.community.community.dto.GithubUser;
import lift.majiang.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName AuthorizedController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/31 14:47
 * @Version 1.0
 **/
@Controller
public class AuthorizedController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.client.uri}")
    private String uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setClient_secret(secret);
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri(uri);
        accesstokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accesstokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
