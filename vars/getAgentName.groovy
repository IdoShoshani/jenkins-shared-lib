#!/usr/bin/env groovy
def call() {
    // Returns the name of the agent the pipeline is running on
    return env.NODE_NAME ?: 'Unknown Agent'
}
