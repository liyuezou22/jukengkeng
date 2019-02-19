app.controller("goodsController", function ($scope, goodsService) {
    $scope.addGoods = function () {
        debugger
        goodsService.addGoods($scope.entity).success(function (response) {
            if (response.flag) {
                alert(response.message);
                $scope.entity = {};
            } else {
                alert(response.message);
            }
        });
    }
});