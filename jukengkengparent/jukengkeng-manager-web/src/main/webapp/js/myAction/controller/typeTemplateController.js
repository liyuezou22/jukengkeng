app.controller("typeTemplateController", function ($scope, $controller, typeTemplateService, brandService, specificationService) {
    $controller("baseController", {$scope: $scope});
    //定义查询对象
    $scope.searchEntity = {};
    //分页查询
    $scope.queryList = function (pageNum, pageSize) {
        typeTemplateService.queryList(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    };

    $scope.brandList = {data: []};
    //获取品牌下拉
    $scope.selectBrandOption = function () {
        brandService.selectBrandOption().success(function (response) {
            $scope.brandList = {data: response};
        });
    };


    $scope.specificationList = {data: []};
    //获取规格下拉列表
    $scope.selectSpecificationOption = function () {
        specificationService.selectSpecificationOption().success(function (response) {
            $scope.specificationList = {data: response};
        });
    };

    //新增扩展属性
    $scope.addCustomAttributeItems = function () {
        $scope.entity.customAttributeItems.push({});
    };

    //删除拓展属性
    $scope.delCustomAttributeItems = function (index) {
        $scope.entity.customAttributeItems.splice(index, 1);
    };

    //保存商品类型模板
    $scope.saveTypeTemplate = function (entity) {
        var id = entity.id;
        if (id == undefined) {
            object = typeTemplateService.saveTypeTemplate(entity);
        } else {
            object = typeTemplateService.updateTypeTemplate(entity);
        }
        object.success(function (response) {
            if (response.flag) {
                alert(response.message);
                $scope.queryList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
            } else {
                alert(response.message);
            }
        });
    };

    //删除商品类型模板
    $scope.delTypeTemplate = function () {
        typeTemplateService.delTypeTemplate($scope.selectIds).success(function (response) {
            if (response.flag) {
                alert(response.message);
                $scope.queryList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
            } else {
                alert(response.message);
            }
        });
    };

    //根据ID查询商品规格模板
    $scope.queryTypeTemlate = function (id) {
        typeTemplateService.queryTypeTemplate(id).success(function (response) {
            $scope.entity = response;
            $scope.entity.brandIds = JSON.parse($scope.entity.brandIds);
            $scope.entity.specIds = JSON.parse($scope.entity.specIds);
            $scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);
        });
    };

    //根据名称查询商品规格模板
    $scope.queryTypeTemlateByName = function () {
        typeTemplateService.queryTypeTemplateByName($scope.searchEntity, $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (response) {
            $scope.list = response.rows;
        });
    };




});