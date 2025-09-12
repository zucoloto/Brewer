$(function() {
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
});

$(document).ready(function () {
      window.setTimeout(function() {
          $(".js-alert-tempo").fadeTo(1000, 0).slideUp(1000, function(){
                 $(this).remove();
          });
      }, 2000);
 });