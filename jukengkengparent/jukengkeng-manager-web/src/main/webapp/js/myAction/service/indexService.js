app.service("indexService", function ($http) {
    this.getLoginName = function () {
        //获取登陆名称
        return $http.post("../login/getName.do");
    }
});