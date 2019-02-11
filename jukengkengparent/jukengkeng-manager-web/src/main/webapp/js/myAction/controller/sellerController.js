app.controller("sellerController",function ($scope,$controller,sellerService) {
    $controller("baseController",{$scope:$scope});//继承baseController控制器

    //获取商家列表
    //查询条件
    $scope.searchEntity = {};
    $scope.queryList = function (pageNum,pageSize) {
        sellerService.queryList(pageNum,pageSize,$scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }

});