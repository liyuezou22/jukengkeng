app.controller("itemCatController", function ($scope, $controller, itemCatService) {
    $controller("baseController", {$scope: $scope});//继承baseController控制器

    //查询商品分类列表
    $scope.queryList = function (pageNum, pageSize) {
        $scope.parent_1 = null;
        $scope.parent_2 = null;
        itemCatService.queryItemCatList(pageNum, pageSize, 0).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }

    //关于面包屑处理方式
    //先定义一个级别,然后再查询下级方法中设置面包屑值
    $scope.grade = 1;
    $scope.setGrade = function (value) {
        $scope.grade = value;
    }


    //查询下级
    $scope.queryNextList = function (pageNum, pageSize, entity) {
        if ($scope.grade == 1) {
            $scope.parent_1 = null;
            $scope.parent_2 = null;
        }
        if ($scope.grade == 2) {
            $scope.parent_1 = entity;
        }
        if ($scope.grade == 3) {
            $scope.parent_2 = entity;
        }
        itemCatService.queryItemCatList(pageNum, pageSize, entity.id).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
            $scope.reload = false;
        });
    }


});