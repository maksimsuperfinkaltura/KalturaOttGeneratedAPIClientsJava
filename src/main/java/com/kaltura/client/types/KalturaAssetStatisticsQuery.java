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
package com.kaltura.client.types;

import org.w3c.dom.Element;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;
import com.kaltura.client.KalturaObjectBase;
import com.kaltura.client.enums.KalturaAssetType;
import com.kaltura.client.utils.ParseUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * This class was generated using clients-generator\exec.php
 * against an XML schema provided by Kaltura.
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

@SuppressWarnings("serial")
public class KalturaAssetStatisticsQuery extends KalturaObjectBase {
	/**  Comma separated list of asset identifiers.  */
    public String assetIdIn;
	/**  Asset type  */
    public KalturaAssetType assetTypeEqual;
	/**  The beginning of the time window to get the statistics for (in epoch).  */
    public long startDateGreaterThanOrEqual = Long.MIN_VALUE;
	/**  /// The end of the time window to get the statistics for (in epoch).  */
    public long endDateGreaterThanOrEqual = Long.MIN_VALUE;

    public KalturaAssetStatisticsQuery() {
    }

    public KalturaAssetStatisticsQuery(Element node) throws KalturaApiException {
        super(node);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node aNode = childNodes.item(i);
            String nodeName = aNode.getNodeName();
            String txt = aNode.getTextContent();
            if (nodeName.equals("assetIdIn")) {
                this.assetIdIn = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("assetTypeEqual")) {
                this.assetTypeEqual = KalturaAssetType.get(ParseUtils.parseString(txt));
                continue;
            } else if (nodeName.equals("startDateGreaterThanOrEqual")) {
                this.startDateGreaterThanOrEqual = ParseUtils.parseBigint(txt);
                continue;
            } else if (nodeName.equals("endDateGreaterThanOrEqual")) {
                this.endDateGreaterThanOrEqual = ParseUtils.parseBigint(txt);
                continue;
            } 
        }
    }

    public KalturaParams toParams() throws KalturaApiException {
        KalturaParams kparams = super.toParams();
        kparams.add("objectType", "KalturaAssetStatisticsQuery");
        kparams.add("assetIdIn", this.assetIdIn);
        kparams.add("assetTypeEqual", this.assetTypeEqual);
        kparams.add("startDateGreaterThanOrEqual", this.startDateGreaterThanOrEqual);
        kparams.add("endDateGreaterThanOrEqual", this.endDateGreaterThanOrEqual);
        return kparams;
    }

}
