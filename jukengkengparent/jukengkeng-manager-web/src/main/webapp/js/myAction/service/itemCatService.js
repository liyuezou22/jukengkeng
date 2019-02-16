app.service("itemCatService", function ($http) {

    //查询分类列表
    this.queryItemCatList = function (pageNum, pageSize, parentID) {
        return $http.post("../ItemCat/queryList.do?pageNum=" + pageNum + "&pageSize=" + pageSize + "&parentID=" + parentID);
    }
});