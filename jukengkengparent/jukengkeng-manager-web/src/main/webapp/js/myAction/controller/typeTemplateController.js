app.controller("typeTemplateController", function ($scope, $controller,typeTemplateService) {
    $controller("baseController", {$scope: $scope});
    //定义查询对象
    $scope.searchEntity = {};
    //分页查询
    $scope.queryList = function (pageNum,pageSize) {
        typeTemplateService.queryList(pageNum,pageSize,$scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }
});