// ===================================================================================================
//                           _  __     _ _
//                          | |/ /__ _| | |_ _  _ _ _ __ _
//                          | ' </ _` | |  _| || | '_/ _` |
//                          |_|\_\__,_|_|\__|\_,_|_| \__,_|
//
// This file is part of the Kaltura Collaborative Media Suite which allows users
// to do with audio, video, and animation what Wiki platfroms allow them to do with
// text.
//
// Copyright (C) 2006-2017  Kaltura Inc.
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
// @ignore
// ===================================================================================================
package com.kaltura.client.services;

import com.kaltura.client.KalturaClient;
import com.kaltura.client.KalturaServiceBase;
import com.kaltura.client.types.*;
import org.w3c.dom.Element;
import com.kaltura.client.utils.ParseUtils;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;

/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
public class KalturaFollowTvSeriesService extends KalturaServiceBase {
    public KalturaFollowTvSeriesService(KalturaClient client) {
        this.kalturaClient = client;
    }

	/**  Add a user&amp;#39;s tv series follow.              Possible status codes:
	  UserAlreadyFollowing = 8013, NotFound = 500007, InvalidAssetId = 4024  */
    public KalturaFollowTvSeries add(KalturaFollowTvSeries followTvSeries) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("followTvSeries", followTvSeries);
        this.kalturaClient.queueServiceCall("followtvseries", "add", kparams, KalturaFollowTvSeries.class);
        if (this.kalturaClient.isMultiRequest())
            return null;
        Element resultXmlElement = this.kalturaClient.doQueue();
        return ParseUtils.parseObject(KalturaFollowTvSeries.class, resultXmlElement);
    }

	/**  Delete a user&amp;#39;s tv series follow.              Possible status codes:
	  UserNotFollowing = 8012, NotFound = 500007, InvalidAssetId = 4024,
	  AnnouncementNotFound = 8006  */
    public boolean delete(int assetId) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("assetId", assetId);
        this.kalturaClient.queueServiceCall("followtvseries", "delete", kparams);
        if (this.kalturaClient.isMultiRequest())
            return false;
        Element resultXmlElement = this.kalturaClient.doQueue();
        String resultText = resultXmlElement.getTextContent();
        return ParseUtils.parseBool(resultText);
    }

    public KalturaFollowTvSeriesListResponse list(KalturaFollowTvSeriesFilter filter) throws KalturaApiException {
        return this.list(filter, null);
    }

	/**  List user&amp;#39;s tv series follows.              Possible status codes:  */
    public KalturaFollowTvSeriesListResponse list(KalturaFollowTvSeriesFilter filter, KalturaFilterPager pager) throws KalturaApiException {
        KalturaParams kparams = new KalturaParams();
        kparams.add("filter", filter);
        kparams.add("pager", pager);
        this.kalturaClient.queueServiceCall("followtvseries", "list", kparams, KalturaFollowTvSeriesListResponse.class);
        if (this.kalturaClient.isMultiRequest())
            return null;
        Element resultXmlElement = this.kalturaClient.doQueue();
        return ParseUtils.parseObject(KalturaFollowTvSeriesListResponse.class, resultXmlElement);
    }
}