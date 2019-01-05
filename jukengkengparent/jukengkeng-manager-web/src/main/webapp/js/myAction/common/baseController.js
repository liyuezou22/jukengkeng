app.controller("baseController",function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,//当前页数
        totalItems: 10,//当前页记录数
        itemsPerPage: 10,//需要查询的数
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };

    //初始化加载
    $scope.reloadList = function () {
        //$scope.findPageList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.queryList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    //定义数组
    $scope.selectIds = [];
    //判断chackbox是否勾选，如果勾选就将当前行ID存到数组中，如果取消勾选就将ID从数组中移除
    $scope.updateSelectState = function ($event, id) {
        if ($event.target.checked) {
            //在数组中添加主键值
            $scope.selectIds.push(id);
        } else {
            //取消勾选
            //获取ID在索引中的位置，并删除
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    };
});