	<div class='modal hide fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>
  <div class='modal-header'>
    <button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>
    <div id='myModalLabel'>
      <h3>

      </h3>
    </div>
  </div>
  <div class='modal-body'>
  </div>
 </div>

<g:javascript>
  $('a.btn').on('click', function(e) {
    e.preventDefault();
    var url = $(this).attr('href');
    $(".modal-body").html('<iframe width="100%" height="100%" frameborder="0" scrolling="no" allowtransparency="true" src="'+url+'"></iframe>');
  });
</g:javascript>