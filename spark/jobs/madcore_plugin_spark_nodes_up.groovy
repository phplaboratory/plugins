pipelineJob('madcore.plugin.spark.nodes.up') {
    parameters {
        stringParam('NODES_IPS', '', 'Comma separated list of IPs.')
    }
    definition {
	    cps {
            sandbox()
            script("""
            node {
                    build job: 'madcore.kubectl.cluster.wait.nodes.up', parameters: [string(name: 'NODES_LABEL', value: 'cluster=spark'), string(name: 'NODES_IPS', value: params.NODES_IPS)]
                }
            """.stripIndent())
	    }
    }
}
