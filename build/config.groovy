
withConfig(configuration) {
    inline(phase: 'CONVERSION') { source, context, classNode ->
        classNode.putNodeMetaData('projectVersion', '3.0.1')
        classNode.putNodeMetaData('projectName', 'mailinglist')
        classNode.putNodeMetaData('isPlugin', 'true')
    }
}
