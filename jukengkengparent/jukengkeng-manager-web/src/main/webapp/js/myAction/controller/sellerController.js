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

    //根据ID查询商家信息
    $scope.querySellerByID = function (id) {
        sellerService.querySellerByID(id).success(function (response) {
            $scope.entity = response;
        });
    }

    //修改审核状态
    $scope.changeStatus = function (id,status) {
        debugger
        sellerService.changeStatus(id,status).success(function (response) {
            debugger
            if(response.flag){
                $scope.reloadList();
                alert(response.message);
            }else{
                alert(response.message);
            }
        });
    }

});