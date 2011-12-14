package org.familysearch.ct.service.api;

import java.util.Date;

import org.familysearch.ct.service.api.contributor.ContributorId;

/**
 * @author Rob Lyon
 */
public interface Attribution {

  ContributorId getContributorId();

  String getProofStatement();

  Date getModified();

}
