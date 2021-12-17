function getImage(input) {
    var c = 0;
    for (var i = 0; i < input.files.length; i++) {

        if (input.files[i] !== null) {

            var reader = new FileReader();

            reader.onload = function (e) {

                var elem = document.getElementById("image");
                var elem1= document.getElementById("image1");
                
                elem.src = e.target.result;
                elem.width="130";
                elem.height="150";
                
                elem1.src = e.target.result;
                elem1.width="130";
                elem1.height="150";
                

                c++;

            };
            reader.readAsDataURL(input.files[i]);
        }
    }
}

