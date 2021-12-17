function getImage(input) {
    var c = 0;
    for (var i = 0; i < input.files.length; i++) {

        if (input.files[i] !== null) {

            var reader = new FileReader();

            reader.onload = function (e) {

                var elem = document.getElementById("image");
                elem.src = e.target.result;
                elem.width="300";
                elem.height="200";
                

                c++;

            };
            reader.readAsDataURL(input.files[i]);
        }
    }
}
