app.controller("indexController",function ($scope,indexService) {
    //获取登陆名称
    indexService.getLoginName().success(function (response) {
        $scope.longinName = response.loginName;
    });
})