app.controller("typeTemplateController", function ($scope, $controller, typeTemplateService,brandService,specificationService) {
    $controller("baseController", {$scope: $scope});
    //定义查询对象
    $scope.searchEntity = {};
    //分页查询
    $scope.queryList = function (pageNum, pageSize) {
        typeTemplateService.queryList(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }

    $scope.brandList = {data: []};
    //获取分页下拉
    $scope.selectBrandOption = function () {
        brandService.selectBrandOption().success(function (response) {
            $scope.brandList = {data: response};
        });
    }


    $scope.specificationList = {data: []};
    //获取规格下拉列表
   $scope.selectSpecificationOption = function () {
       specificationService.selectSpecificationOption().success(function (response) {
            $scope.specificationList ={data:response};
       });
   } 

});