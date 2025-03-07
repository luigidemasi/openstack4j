package org.openstack4j.openstack.networking.domain;

import org.openstack4j.model.network.ExternalGateway;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * Configurable external gateway modes extension model.  By default, when a gateway is attached to a router using the Neutron L3 extension,
 * Network Address Translation (NAT) is enabled for traffic generated by subnets attached to the router. With this extension, the user will
 * have the option of choosing whether SNAT should be enabled or not on a router basis.
 *
 * @author Jeremy Unruh
 * @see http://docs.openstack.org/api/openstack-network/2.0/content/extgwmodes-ext.html
 */
public class NeutronExternalGateway implements ExternalGateway {

	private static final long serialVersionUID = 1L;

	@JsonProperty("network_id")
	private String networkId;

	@JsonProperty("enable_snat")
	private Boolean enableSnat;

	@JsonProperty("external_fixed_ips")
	private List<NeutronEternalFixedIps> externalFixedIps;

	public NeutronExternalGateway() { }

	public NeutronExternalGateway(String networkId) {
	  this(networkId, Boolean.TRUE);
	}

	public NeutronExternalGateway(String networkId, Boolean enableSnat) {
		this.networkId = networkId;
		this.enableSnat = enableSnat;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNetworkId() {
		return networkId;
	}

	/**
	 * {@inheritDoc}
	 */
	@JsonIgnore
	@Override
	public boolean isEnableSnat() {
		return enableSnat != null && enableSnat;
	}

	public List<NeutronEternalFixedIps> getExternalFixedIps() {
		return externalFixedIps;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				    .add("networkId", networkId).add("enable_snat", enableSnat).toString();
	}

}
