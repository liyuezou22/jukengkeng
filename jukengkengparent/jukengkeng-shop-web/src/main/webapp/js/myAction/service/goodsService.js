app.service("goodsService", function ($http) {
    //新增商品
    this.addGoods = function (entity) {
        return $http.post("../goods/addGoods.do",entity);
    }
})