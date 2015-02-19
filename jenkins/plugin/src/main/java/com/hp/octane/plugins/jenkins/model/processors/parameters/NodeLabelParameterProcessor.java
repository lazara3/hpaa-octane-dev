package com.hp.octane.plugins.jenkins.model.processors.parameters;

import com.hp.octane.plugins.jenkins.model.api.ParameterConfig;
import com.hp.octane.plugins.jenkins.model.api.ParameterInstance;
import com.hp.octane.plugins.jenkins.model.parameters.ParameterType;
import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;
import org.jvnet.jenkins.plugins.nodelabelparameter.LabelParameterDefinition;
import org.jvnet.jenkins.plugins.nodelabelparameter.NodeParameterDefinition;

import java.util.ArrayList;

/**
 * Created by gullery on 19/02/2015.
 */

public class NodeLabelParameterProcessor extends AbstractParametersProcessor {
	private static final NodeLabelParameterProcessor instance;

	static {
		instance = new NodeLabelParameterProcessor();
	}

	private NodeLabelParameterProcessor() {
	}

	public static NodeLabelParameterProcessor getInstance() {
		return instance;
	}

	@Override
	public ParameterConfig createParameterConfig(ParameterDefinition pd) {
		if (pd instanceof NodeParameterDefinition) {
			NodeParameterDefinition nodePd = (NodeParameterDefinition) pd;
			return new ParameterConfig(pd, ParameterType.STRING, new ArrayList<Object>(nodePd.allowedSlaves));
		} else if (pd instanceof LabelParameterDefinition) {
			LabelParameterDefinition labelPd = (LabelParameterDefinition) pd;
			return new ParameterConfig(pd, ParameterType.STRING);
		} else {
			return new ParameterConfig(pd);
		}
	}

	@Override
	public ParameterInstance createParameterInstance(ParameterDefinition pd, ParameterValue pv) {
		return new ParameterInstance(createParameterConfig(pd), pv.getValue());
	}
}
