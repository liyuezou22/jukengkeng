app.controller("specificationController", function ($scope, $controller, specificationService) {
    $controller("baseController", {$scope: $scope});
    //定义查询对象
    $scope.searchEntity = {};
    //分页查询
    $scope.queryList = function (pageNum, pageSize) {
        specificationService.queryList(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }
    //新增规格选项
    $scope.addSpecificationList = function () {
        $scope.entity.tbSpecificationOptions.push({});
    }
    //删除规格选项
    $scope.delSpecificationOption = function (index) {
        $scope.entity.tbSpecificationOptions.splice(index, 1);
    }
    //新增规格选项
    $scope.addSpecification = function (specification) {
        var id = specification.tbSpecification.id;
        //判断是新增还是修改
        if (id != null) {
            object = specificationService.updateSpecification(specification);
        } else {
            object = specificationService.addSpecification(specification);
        }
        if (confirm("是否确认保存？")) {
            object.success(function (response) {
                debugger
                if (response.flag) {

                    alert(response.message);
                    $scope.queryList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
                } else {

                    alert(response.message);
                }
            });
        }

    }
    //删除规格
    $scope.delSpecification = function () {
        specificationService.delSpecifciation($scope.selectIds).success(function (response) {
            if (response.flag) {
                alert(response.message);
                $scope.queryList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
            } else {
                alert(response.message);
            }
        });
    }
    //根据ID查询规格及规格选项
    $scope.findSpecificaitonByID = function (id) {
        specificationService.findSpecificaitonByID(id).success(function (response) {
            $scope.entity = response;
        });
    }
});