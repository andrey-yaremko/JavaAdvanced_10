$("button.createProduct")
    .click(
        function() {

            var name = $("form.createProduct input.productName").val();
            var description = $("form.createProduct input.productDescription").val();
            var price = $("form.createProduct input.productPrice").val();

            var product = {
                name : name,
                description : description,
                price : price
            };

            $.post("ProductServlet", product,
                function(data) {
                    if (data == 'Success') {
                        alert('Success');
                    }
                });

        });
$("button.buy-product").click(function(){
    let productId = jQuery(this).attr("product-id");

    $.post("BucketController", {'productId':productId},
        function(data) {
            if (data == 'Success') {
                $("[data-dismiss=modal]").trigger({ type: "click"});

            }
        });
});