<script type="text/javascript">
    var elems = document.getElementsByClassName('edit_confirmation');
    var confirmIt = function (e) {
        if (!confirm('Are you sure edit?')) e.preventDefault();
    };
    for (var i = 0, l = elems.length; i < l; i++) {
        elems[i].addEventListener('click', confirmIt, false);
    }
</script>