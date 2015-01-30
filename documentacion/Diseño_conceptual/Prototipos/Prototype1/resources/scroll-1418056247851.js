(function(window, undefined) {

    /*********************** START STATIC ACCESS METHODS ************************/

    jQuery.extend(jimMobile, {
        "loadScrollBars": function() {
            jQuery(".s-7b2f4b96-102e-48b4-8cf9-c5b10372fa68 .ui-page").overscroll({ showThumbs:true, direction:'vertical' });
            jQuery(".s-3dd76a99-d955-4b1d-886b-0b1e0e744f8f .ui-page").overscroll({ showThumbs:true, direction:'vertical' });
            jQuery(".s-d12245cc-1680-458d-89dd-4f0d7fb22724 .ui-page").overscroll({ showThumbs:true, direction:'multi' });
            jQuery(".s-37910d8c-1523-4da9-8c67-72f83d345dbe .ui-page").overscroll({ showThumbs:true, direction:'vertical' });
         }
    });

    /*********************** END STATIC ACCESS METHODS ************************/

}) (window);