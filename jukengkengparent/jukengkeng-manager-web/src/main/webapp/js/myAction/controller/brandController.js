//定义控制器
app.controller("jkkController", function ($scope, $controller,brandService) {
    $controller("baseController",{$scope:$scope});//继承baseController控制器
    //获取商品列表
    brandService.findAll().success(function (response) {
        $scope.list = response;
    });

    //新增
    $scope.add = function () {
        //判断是否存在ID，如果ID不为空则进行更新操作，如果ID为空则进行新增
        // var method = "add";
        var id = $scope.entity.id;
        if (id != null) {
            object = brandService.updateTbBrand($scope.entity);
        }else{
            object = brandService.add($scope.entity);
        }
        object.success(function (response) {
            if (response.flag) {
                $scope.reloadList(); //刷新列表
                alert(response.message);
            } else {
                alert(response.message);
            }
        });
    };

    //根据主键查询
    $scope.findByID = function (id) {
        brandService.findByID(id).success(function (response) {
            $scope.entity = response;
        });
    };


    //删除
    $scope.del = function () {
        if (confirm("是否确认删除？")) {
            brandService.del($scope.selectIds).success(function (response) {
                if (response.flag) {
                    $scope.reloadList(); //刷新列表
                    alert(response.message);
                } else {
                    alert(response.message);
                }
            });

        }
    };
    $scope.searchEntity = {};//定义搜索对象
    //条件查询
    $scope.queryList = function (pageNum, pageSize) {
        brandService.queryList(pageNum,pageSize,$scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }
});