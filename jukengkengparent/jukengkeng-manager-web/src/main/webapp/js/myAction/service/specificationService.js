app.service("specificationService", function ($http) {
    //分页查询service
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../specification/findPageList.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }

    //新增规格及规格选项
    this.addSpecification = function (specification) {
        return $http.post("../specification/add.do", specification);
    }

    //删除规格及规格选项
    this.delSpecifciation = function (selectIds) {
        return $http.post("../specification/del.do?id=" + selectIds);
    }

    //根据ID查询规格及规格选项
    this.findSpecificaitonByID = function (id) {
        return $http.post("../specification/findSpecificationByID.do?id=" + id);
    }

    //更新规格及规格选项
    this.updateSpecification = function (specification) {
        return $http.post("../specification/updateSpecification.do", specification);
    }
    
    //获取规格下拉列表数据
    this.selectSpecificationOption = function () {
        return $http.post("../specification/selectSpecificationOption.do");
    }
});