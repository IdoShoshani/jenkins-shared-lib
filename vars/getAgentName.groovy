#!/usr/bin/env groovy
def call() {
    // Retrieve the agent name where the pipeline is currently running
    def agentName = env.NODE_NAME ?: 'Unknown Agent'

    if (agentName == 'Unknown Agent') {
        error "Agent name could not be determined. Ensure the pipeline is running on an agent."
    }

    echo "Current agent: ${agentName}"
    return agentName
}
