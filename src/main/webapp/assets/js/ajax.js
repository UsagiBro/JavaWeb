$(document).ready(function(){
   $('.addToCartButton').click(function() {
    var insName = this.id;
    $.ajax({
        url: '/addToCart?insName='+insName,
        method: "PUT",
        success: function(data) {
            $("#cart").load(location.href+" #cart>*","");
        }
    });
       return false;
});
})
