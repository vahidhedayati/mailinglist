import org.springframework.context.annotation.DependsOn

// Resource declarations for Resources plugin

modules = {

   'tinyMce' {
      dependsOn: 'jquery'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce', file:"tiny_mce.js"], disposition: 'head'
   }

   'tinyMce-widget' {
      dependsOn: 'tinyMce'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce', file:"jquery.tinymce.js"], disposition: 'head'
   }

   'tinyMce-codemagic' {
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce', file:"tiny_mce_popup.js"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/js', file:"codemirror-compressed.js"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/js', file:"codemagic.js"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/js', file:"beautify.js"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/js', file:"beautify-html.js"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/css', file:"style.css"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/css', file:"codemirror.css"], disposition: 'head'
      resource url: [plugin: 'tinyMce', dir:'js/tinymce/jscripts/tiny_mce/plugins/codemagic/css', file:"default.css"], disposition: 'head'
   }
}
