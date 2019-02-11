app.controller("sellerController",function ($scope,sellerService) {
    //新增商家：商家入驻
    $scope.addSeller = function () {
        sellerService.addSeller($scope.entity).success(function (response) {
            if(response.flag){
                alert(response.message);
                location.href="shoplogin.html";
            }else{
                alert(response.message);
            }
        });
    }
});