#!/usr/bin/env groovy
def call(Map params = [:]) {
    // Extract parameters with default values
    def agent = params.get('agent', null)
    def jobName = params.get('job', null)
    def propagate = params.get('propagate', true)
    def wait = params.get('wait', true)

    if (!jobName) {
        error "Job name is required to trigger a job."
    }

    if (!agent) {
        error "Agent name is required to trigger the job."
    }

    echo "Triggering job '${jobName}' on agent '${agent}' with propagate=${propagate} and wait=${wait}"

    // Trigger the job with agent passed as a parameter
    def job = build job: jobName,
                     parameters: [string(name: 'agent', value: agent)],
                     propagate: propagate,
                     wait: wait

    return job
}
