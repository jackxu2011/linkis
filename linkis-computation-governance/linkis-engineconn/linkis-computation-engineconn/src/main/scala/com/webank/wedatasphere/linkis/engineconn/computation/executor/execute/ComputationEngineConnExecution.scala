/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.engineconn.computation.executor.execute

import com.webank.wedatasphere.linkis.engineconn.common.creation.EngineCreationContext
import com.webank.wedatasphere.linkis.engineconn.common.engineconn.EngineConn
import com.webank.wedatasphere.linkis.engineconn.core.execution.AbstractEngineConnExecution
import com.webank.wedatasphere.linkis.engineconn.executor.entity.Executor
import com.webank.wedatasphere.linkis.manager.label.entity.engine.EngineConnMode._


class ComputationEngineConnExecution extends AbstractEngineConnExecution {

  override protected def getSupportedEngineConnModes: Array[EngineConnMode] =
    Array(Computation, Computation_With_Once)

  override protected def doExecution(executor: Executor,
                                     engineCreationContext: EngineCreationContext,
                                     engineConn: EngineConn): Unit = {
    info(s"Executor(${executor.getId}) is started. Now wait to be ready.")
  }

  /**
    * Usually, computation is in final.
    *
    * @return
    */
  override def getOrder: Int = 10
}
